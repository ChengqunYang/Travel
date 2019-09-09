package com.monster.travel.web.servlet;

import com.monster.travel.domain.Category;
import com.monster.travel.service.CategoryService;
import com.monster.travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService service = new CategoryServiceImpl();

    /**
     * 查询所有的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.调用service查询所有
        List<Category> cs = service.findAll();
    //2.调用父类的方法,序列化json并返回
        writeValue(cs,response);

    }
}
