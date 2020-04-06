package io.jumpco.demo.todo.model;

public enum Grading {
    INCOMPLETE, PARTIAL_COMPLETE, COMPLETE;
 Grading(){}

private String grading;

    Grading(String grading) {
        this.grading = grading;
    }

    public String getGrading(){
        return grading;
    }
}
