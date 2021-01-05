package com.github.wangran99.welink.api.client.openapi.model;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ExcelRes<T> {

    // excel文件数据行数
    private Integer size;

    // 读取成功的list
    private List<T> success_list;

    // 读取失败的list
    private List<T> error_list;

    // 读取为空行的行号
    private List<Integer> blank_lines;

    // 有问题的行号，及相关说明
    private Map<Integer, List<String>> error_info;

}
