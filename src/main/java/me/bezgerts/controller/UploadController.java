package me.bezgerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    @Autowired
    private Environment env;

    @GetMapping("/upload")
    public String uploadFile() {
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Пожалуйста выберите файл для загрузки");
            return "redirect:upload";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(env.getProperty("folder_with_uploaded_files") + file.getOriginalFilename());

            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "Вы успешно загрузили файл: '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/upload";
    }
}
