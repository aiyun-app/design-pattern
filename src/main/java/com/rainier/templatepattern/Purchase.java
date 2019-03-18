package com.rainier.templatepattern;

import java.math.BigDecimal;

public abstract class Purchase {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private BigDecimal amount;

    public Purchase(String userName, BigDecimal amount) {
        this.userName = userName;
        this.amount = amount;
    }

    protected void Submit(){

        //1.部门主管审批
        supervisorApprove();

        //2直属经理审批
        lineManagerApprove();

        //3会签
        cosign();

        //4.如果需要总经理审批
        if(needGMApprove()){
            generalManagerApprove();
        }

        //5.生成采购订单
        purchaseOrder();


    }

    protected boolean needGMApprove(){
        return  false;
    }

    //1. 主管审批
    private void supervisorApprove(){
        System.out.println("主管审批完成");
    }

    //直属经理审批
    private void lineManagerApprove(){
        System.out.println("直属经理审批完成");
    }

    //会签
    private void cosign(){
        System.out.println("会签完成");
    }

    //总经理审批
    protected abstract void generalManagerApprove();

    //生成采购订单
    private void purchaseOrder(){
        System.out.println("生成采购订单");
    }


}
