package com.examination.controller;

import com.examination.dto.SongDto;
import com.examination.model.Genre;
import com.examination.model.Song;
import com.examination.service.IGenreService;
import com.examination.service.ISongService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @Autowired
    private IGenreService genreService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 0, size = 4, sort = "id") Pageable pageable,
                           @RequestParam(defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "") String genreName,
                           RedirectAttributes redirectAttributes, Model model) {
        Page<Song> songPage = songService.getAll(pageable, searchName, genreName);
        model.addAttribute("searchName", searchName);
        model.addAttribute("genreName", genreName);
        List<Genre> genreList = genreService.getAll();
        model.addAttribute("genreList", genreList);
        model.addAttribute("songPage", songPage);
        return "/list";
    }

    @GetMapping("/showCreateForm")
    public String showCreateForm(Model model) {
        SongDto songDto = new SongDto();
        model.addAttribute("songDto", songDto);
        List<Genre> genreList = genreService.getAll();
        model.addAttribute("genreList", genreList);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDto", songDto);
            List<Genre> genreList = genreService.getAll();
            model.addAttribute("genreList", genreList);
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("msg", "Add successfully");
        return "redirect:/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String id, RedirectAttributes redirectAttributes) {
        songService.deleteById(Integer.valueOf(id));
        redirectAttributes.addFlashAttribute("msg", "Delete successfully");
        return "redirect:/list";
    }
}
