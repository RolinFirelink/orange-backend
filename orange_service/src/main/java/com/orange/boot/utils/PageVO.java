package com.orange.boot.utils;

import lombok.Data;

import java.util.List;


/**
 * @author LZH
 * @date 2022/3/20
 * @apiNote
 */

@Data
public class PageVO<T> {

    private List<T> result;
    private int page;
    private int pageSize;
    private long total;
}
