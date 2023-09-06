package com.orange.boot.environment.util;

import com.orange.boot.environment.entity.EnvironmentData;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Lin
 * @Date: 2022/9/9/14:53
 * @Description:
 */

public class MapToEnvironmentDataConverter {

    public static EnvironmentData[] MapToEnvironmentData(List<HashMap> map) {
        EnvironmentData[] data = new EnvironmentData[map.size()];
        for (int i = 0; i < map.size(); i++) {
            data[i] = new EnvironmentData(
                    (Integer) map.get(i).get("id"),
                    (String) map.get(i).get("code"),
                    (String) map.get(i).get("name"),
                    new Double(String.valueOf(map.get(i).get("value"))),
                    (String) map.get(i).get("valueText"),
                    (String) map.get(i).get("unit"),
                    (String) map.get(i).get("icon"),
                    (Integer) map.get(i).get("Level"),
                    (Long) map.get(i).get("sourceMachine")
            );
        }
        return data;
    }
}
