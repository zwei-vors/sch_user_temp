package com.sparta.demo_sch_user.service;

import com.sparta.demo_sch_user.dto.ScheduleRequestDto;
import com.sparta.demo_sch_user.dto.ScheduleResponseDto;
import com.sparta.demo_sch_user.dto.ScheduleResponsePageDto;
import com.sparta.demo_sch_user.entity.Schedule;
import com.sparta.demo_sch_user.entity.User;
import com.sparta.demo_sch_user.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserService userService;
    private final CommentService commentService;

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        return schedules
                .stream()
                .sorted(Comparator.comparing(Schedule::getCreatedAt).reversed())
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleResponseDto findById(Long id) {
        return ScheduleResponseDto.toDto(findScheduleById(id));

    }

    private Schedule findScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 ID 값 입니다."));
    }

    public Page<ScheduleResponsePageDto> getSchedules(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("modifiedAt").descending());
        Page<Schedule> schedules = scheduleRepository.findAll(pageable);

        // Convert entities to DTOs with comment count
        return schedules.map(schedule -> {
            Long commentCount = commentService.countByScheduleId(schedule.getId());
            return new ScheduleResponsePageDto(
                    schedule.getTitle(),
                    schedule.getDescription(),
                    commentCount.intValue(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt(),
                    schedule.getUser().getWriterName()
            );
        });
    }

    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        User user = userService.findUserById(requestDto.getUserId());
        Schedule schedule = new Schedule(user, requestDto.getTitle(), requestDto.getDescription());

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return ScheduleResponseDto.toDto(savedSchedule);
    }

    @Transactional
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = findScheduleById(id);
        schedule.update(scheduleRequestDto.getTitle(), scheduleRequestDto.getDescription());
        return ScheduleResponseDto.toDto(schedule);
    }
}
