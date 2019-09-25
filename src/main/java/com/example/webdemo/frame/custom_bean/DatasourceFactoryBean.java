package com.example.webdemo.frame.custom_bean;

import org.springframework.beans.factory.FactoryBean;

public class DatasourceFactoryBean implements FactoryBean<DatasourceInfo> {

    private String datasourceInfo;

    public String getDatasourceInfo() {
        return datasourceInfo;
    }

    public void setDatasourceInfo(String datasourceInfo) {
        this.datasourceInfo = datasourceInfo;
    }

    @Override
    public DatasourceInfo getObject() throws Exception {
        DatasourceInfo datasource = new DatasourceInfo();
        String[] infos = datasourceInfo.split(",");
        datasource.setUrl(infos[0]);
        datasource.setUserName(infos[1]);
        datasource.setPassword(infos[2]);
        return datasource;
    }

    @Override
    public Class<?> getObjectType() {
        return DatasourceInfo.class;
    }

    @Override
    public String toString() {
        return "DatasourceFactoryBean{" +
                "datasourceInfo='" + datasourceInfo + '\'' +
                '}';
    }
}
