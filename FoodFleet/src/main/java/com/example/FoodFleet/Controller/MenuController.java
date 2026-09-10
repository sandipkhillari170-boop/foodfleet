package com.example.FoodFleet.Controller;

import com.example.FoodFleet.DTOMenu.CreateMenuRequestDto;
import com.example.FoodFleet.DTOMenu.ResponseMenuDto;
import com.example.FoodFleet.DTOMenu.UpdateMenuRequestDto;
import com.example.FoodFleet.Service.MenuService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<ResponseMenuDto> create(
            @Valid  @RequestBody CreateMenuRequestDto requestDto){
        return ResponseEntity.ok(menuService.cteate(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMenuDto> get(@PathVariable Long id){
        return ResponseEntity.ok(menuService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponseMenuDto>> getAll(){
        return ResponseEntity.ok(menuService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMenuDto> update(@PathVariable Long id,
                                                  @Valid @RequestBody UpdateMenuRequestDto requestDto){
        return ResponseEntity.ok(menuService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(menuService.delete(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> softDelete(@PathVariable Long id){
        return ResponseEntity.ok(menuService.softDelete(id));
    }
}
