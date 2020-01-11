package com.example.mapstructmaplist;

public class MapeamentoImpl <T ,R >{
    private T source1;
    private R source2;

    public MapeamentoImpl (T source1, R source2){
        this.source1 =source1;
        this.source2 =source2;
    }

    public T getSource1() {
        return source1;
    }

    public R getSource2() {
        return source2;
    }
}

