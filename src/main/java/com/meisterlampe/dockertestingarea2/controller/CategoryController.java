package com.meisterlampe.dockertestingarea2.controller;
import com.meisterlampe.dockertestingarea2.entities.Category;
import com.meisterlampe.dockertestingarea2.repository.CategoryRepository;
import com.meisterlampe.dockertestingarea2.services.CategoryService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
@Getter
@Setter
@AllArgsConstructor
public class CategoryController {

    @Resource
    CategoryRepository categoryRepository;
    private final CategoryService categoryService;


    @RequestMapping(value = "/category/all", method = RequestMethod.GET)
    public Iterable<Category> allCategorys(){

        List<Category> categoryList=  categoryRepository.findAll();

        return categoryList;
    }

    @RequestMapping(value="/category/add",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCategory(@RequestBody Category category){

        categoryRepository.save(category);

    }


    @RequestMapping(value="/category/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCategorybyID(@RequestBody Category idcategory){

        categoryRepository.delete(idcategory);

    }

    @RequestMapping(value="/category/update/{idcategory}", method = RequestMethod.PUT)
    public Optional<Category> updateCategoryById( @PathVariable int idcategory,  @RequestBody Category categoryUpdate){

        Optional<Category> updateCategory = categoryService.updateCategoriesByIdcategory(idcategory,categoryUpdate);

        if(updateCategory.isPresent()){
            return Optional.of(categoryUpdate);
        }
        else{
            return Optional.empty();
        }
    }

}
