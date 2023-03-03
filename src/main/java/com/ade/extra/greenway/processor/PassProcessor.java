package com.ade.extra.greenway.processor;

import com.ade.extra.greenway.listener.event.PassCarEvent;
import com.ade.extra.greenway.repository.PassRecordRepository;
import com.ade.extra.greenway.service.ControlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.ade.extra.greenway.processor.SwitchConst.*;
import static com.ade.extra.greenway.processor.SignalLightConst.*;

/**
 * 通行处理器
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PassProcessor implements IProcessor {

    private final ControlService controlService;
    private final PassRecordRepository passRecordRepository;

    // 当前车辆，通行流程只处理一辆车
    private PassCar current;

    @Override
    public void event(PassCarEvent event) {
        switch (event) {
            case STRESS_1_DOWN:
                log.info("地感线圈被按下");
                if (current == null) { // 无车状态，启动新一轮流程
                    // 获取车牌号
                    String carNo = getCarNo();
                    log.info("当前车辆: {}", carNo);
                    if (isReserved(carNo)) { // 已预约

                    } else {
                        // TODO 通知入口显示屏显示预约界面，该线程结束
                        //      预约完成后，预约线程需要再次传入STRESS_DOWN事件
                    }
                    // TODO 获取预约状态
                } else {
                    // TODO 上一轮流程还未结束
                }
                break;
            case STRESS_1_UP:
                break;
            case INFRARED_1_OFF: // 红外1断开
                if (current.getStatus() == 1) { // 抬杆等车进入状态
                    // 打开X发射
                    controlService.shootX(OPEN);
                    // 打开X接收
                    controlService.receiveX(OPEN);
                    current.setStatus(3); // 进入x区域
                }
                break;
            case INFRARED_1_ON: // 红外1连通
                if (current.getStatus() == 3) { // 车辆经过x区域
                    // 获取扫描图片
                    final String xImageUrl = getXImageUrl();
                    // 更新数据

                    // 关闭X发射
                    controlService.shootX(CLOSE);
                    // 关闭X接收
                    controlService.receiveX(CLOSE);
                    current.setStatus(3); // 进入x区域
                }
                break;
            case INFRARED_2_OFF: // 红外2断开
                break;
            case INFRARED_2_ON: // 红外2连通
                break;
            default:

        }
    }

    private String getCarNo() {
        // TODO 实现获取车牌号：需要对接摄像头
        return "";
    }

    private boolean isReserved(String carNo) {
        // TODO 查询是否预约
        return false;
    }

    private void carIn(String no) {
        current = new PassCar();
        current.setNo(no);
        // 信号灯 -> 绿
        controlService.signalLight(Green);
        // 路障 -> 开
        controlService.roadblock(OPEN);
        // 设置车辆状态 -> 准备进入检查岛
        current.setStatus(1);
    }

    private String getXImageUrl() {
        // TODO 获取X扫描图 返回地址
        return null;
    }

}
