package com.xiao.web.admin;


import com.xiao.po.Type;
import com.xiao.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 分页处理PageableDefault设置分页参数
     * @param pageable
     * @param model
     * @return
     */
    @GetMapping("/types")
    public String types(@PageableDefault(size = 8,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable
    , Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    /**
     *跳转新增页面
     */
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }
    /**
     * 新增
     */
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes){
        Type type1=typeService.getTypeByName(type.getName());
        if (type1 !=null){
            attributes.addFlashAttribute("message","该组已存在请勿重复提交");
            return "redirect:/admin/types";
        }
        //不能为空
        if (result.hasErrors()){
            return "admin/types-input";
        }
        Type t=typeService.saveType(type);
        if (t==null){
            //没保存成功
            attributes.addFlashAttribute("message","新增失败");
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/types";
    }

    /**
     * 跳转修改页面
     */
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }

    /**
     * 修改
     */

    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type,BindingResult result,@PathVariable Long id, RedirectAttributes attributes){
        Type type1=typeService.getTypeByName(type.getName());
        if (type1!=null){
            attributes.addFlashAttribute("message","该组已存在请勿重复提交");
            return "redirect:/admin/types";
        }
        //不能为空
        if (result.hasErrors()){
            return "admin/types-input";
        }
        Type t=typeService.updateType(id,type);
        if (t==null){
            //没保存成功
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";
    }

    /**
     * 删除
     */
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }




}
