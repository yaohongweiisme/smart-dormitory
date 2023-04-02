package com.ruoyi.web.core.config;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.dormitory.stuDormitory.domain.Dormitory;
import com.ruoyi.dormitory.stuDormitory.service.IDormitoryService;
import com.ruoyi.performance.totalScore.domain.DorTotalScore;
import com.ruoyi.performance.totalScore.service.IDorTotalScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableScheduling
public class ScheduleTask {
    @Autowired
    private IDorTotalScoreService dorTotalScoreService;
    @Autowired
    private IDormitoryService dormitoryService;

    public class SaticScheduleTask {
        //3.添加定时任务
        @Scheduled(cron = "0 0 23 L * ?")
        private void configureTasks() {
            System.err.println("执行生成次月宿舍总分数单任务时间: " + LocalDateTime.now());
            Calendar calendar = Calendar.getInstance();
            // 获取次月
            int month = calendar.get(Calendar.MONTH) + 2;
            String title= month +"月宿舍总分数表";
            List<Dormitory> dormitories = dormitoryService.selectDormitoryList(null);
            List<DorTotalScore> totalScoreList = dormitories.stream().map(dor -> {
                DorTotalScore dorTotalScore = new DorTotalScore();
                dorTotalScore.setDorId(dor.getDorId());
                dorTotalScore.setTitle(title);
                dorTotalScore.setBuildTime(DateUtils.getNowDate());
                dorTotalScore.setBuildingId(dor.getBuildingId());
                return dorTotalScore;
            }).collect(Collectors.toList());
            dorTotalScoreService.saveBatch(totalScoreList);
        }
    }
}