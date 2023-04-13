package com.xbl.designPattern._10_facedePattern.processes;

public abstract class Processes {
    public String processName;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public void doProcesses(){
        System.out.println(this.processName+"流程开始");
    }
}
