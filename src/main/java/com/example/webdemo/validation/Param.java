

package com.example.webdemo.validation;

import java.lang.annotation.Annotation;

public class Param {
    private String simpleName;
    private String name;
    private Class<?> type;
    private Object value;
    private Annotation anno;

    public Param() {
    }

    public Param(String simpleName, String name, Class<?> type, Object value, Annotation anno) {
        this.simpleName = simpleName;
        this.name = name;
        this.type = type;
        this.value = value;
        this.anno = anno;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Annotation getAnno() {
        return anno;
    }

    public void setAnno(Annotation anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "Param{" +
                "simpleName='" + simpleName + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", value=" + value +
                ", anno=" + anno +
                '}';
    }
}
