package com.woniu.command.workercommand;

import com.woniu.command.Command;
import com.woniu.inlet.web.vo.WorkerVo;
import com.woniu.outlet.po.WorkerPo;
import com.woniu.service.impl.WorkerCommandHandler;
import com.woniu.util.ApplicationContextHolder;
import io.swagger.models.auth.In;

public class DeleteWorkerCommand implements Command<WorkerPo, Integer> {

    private WorkerCommandHandler commandHandler;

    public DeleteWorkerCommand(){
        this.commandHandler = ApplicationContextHolder.getApplicationContext().getBean(WorkerCommandHandler.class);
    }

    @Override
    public Integer excute(WorkerPo workerPo) {
        return this.commandHandler.deleteWorker(workerPo);
    }
}
