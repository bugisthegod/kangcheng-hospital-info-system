package com.woniu.command.workercommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.WorkerPo;
import com.woniu.service.impl.WorkerCommandHandler;
import com.woniu.util.ApplicationContextHolder;

public class AddWorkerCommand implements Command<WorkerPo,Integer> {

    private WorkerCommandHandler commandHandler;

    public AddWorkerCommand(){
        this.commandHandler = ApplicationContextHolder.getApplicationContext().getBean(WorkerCommandHandler.class);
    }

    @Override
    public Integer excute(WorkerPo workerPo) {
        return this.commandHandler.addWorker(workerPo);
    }
}
