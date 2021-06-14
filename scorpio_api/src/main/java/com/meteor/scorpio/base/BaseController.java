package com.meteor.scorpio.base;

import com.meteor.scorpio.common.PageResult;
import com.meteor.scorpio.parameter.Filter;
import com.meteor.scorpio.parameter.SimpleFilterResolver;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
public abstract class BaseController<T extends BaseEntity> {

    public abstract BaseService service();

    /**
     * 动态查询
     * @param simpleFilterResolver
     * @return
     */
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public PageResult filter(@Filter SimpleFilterResolver<T> simpleFilterResolver) {
        Page<T> page = service().filter(simpleFilterResolver);
        PageResult<T> result = new PageResult<>();
        result.setItems(page.getContent());
        result.setTotal(page.getTotalElements());
        result.setTotalPage((long) page.getTotalPages());
        result.setMsg("查询列表成功");
        result.setCode("200");
        return result;
    }

    @PostMapping("/add")
    public PageResult add(@RequestBody T entity) {
        PageResult<T> r = new PageResult<>();
        try {
            service().save(entity);
            r.setCode("100");
            r.setMsg("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            r.setCode("101");
            r.setMsg("新增失败");
        }
        return r;
    }

    @PutMapping("/update")
    public PageResult update(@RequestBody T entity) {
        PageResult<T> r = new PageResult<>();
        try {
            service().update(entity);
            r.setCode("100");
            r.setMsg("新增成功");
        } catch (Exception e) {
            r.setCode("101");
            r.setMsg("新增失败");
        }
        return r;
    }

}
