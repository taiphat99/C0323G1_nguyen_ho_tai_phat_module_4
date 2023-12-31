package com.song.controller;

import com.song.dto.SongDTO;
import com.song.model.Genre;
import com.song.model.Song;
import com.song.service.genre.IGenreService;
import com.song.service.song.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;
    @Autowired
    private IGenreService genreService;
    @RequestMapping("")
    public String showList(@PageableDefault(value = 0, size = 5, sort = "id") Pageable pageable,
                           @RequestParam (defaultValue = "") String searchName,
                           Model model){
        Page<Song> songPage = songService.findSongByNameContaining(pageable, searchName);
        model.addAttribute("songPage",songPage);
        model.addAttribute("searchName",searchName);
        return "list";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute SongDTO songDTO,BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model){
        System.out.println(songDTO.getGenre());
        new SongDTO().validate(songDTO,bindingResult);

        if(bindingResult.hasErrors()){
//           redirectAttributes.addFlashAttribute("songDTO",songDTO);
//            return "redirect:/song/add";
            List<Genre> genres = genreService.findAll();
            model.addAttribute("genres",genres);
            model.addAttribute("songDTO",songDTO);
            return "/create-form";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("msg","Add successfully!");
        return "redirect:/song";
    }
    @GetMapping("/add")
    public String showFormCreate(Model model){
        model.addAttribute("songDTO",new SongDTO());
        List<Genre> genres = genreService.findAll();
        model.addAttribute("genres",genres);
        return "/create-form";
    }


}
