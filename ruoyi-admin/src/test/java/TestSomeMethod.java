import com.ruoyi.RuoYiApplication;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.dormitory.stuDormitory.domain.Dormitory;
import com.ruoyi.dormitory.stuDormitory.service.IDormitoryService;
import com.ruoyi.performance.totalScore.domain.DorTotalScore;
import com.ruoyi.performance.totalScore.service.IDorTotalScoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest(classes = RuoYiApplication.class)
public class TestSomeMethod {
    @Autowired
    private IDorTotalScoreService dorTotalScoreService;
    @Autowired
    private IDormitoryService dormitoryService;

    @Test
    public void configureTasks() {
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
