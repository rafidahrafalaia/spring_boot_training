package com.bcaf.ivan.SpringBootThymeleaf.Controller;

import com.bcaf.ivan.SpringBootThymeleaf.Entity.Mahasiswa;
import com.bcaf.ivan.SpringBootThymeleaf.Entity.MahasiswaExt;
import com.bcaf.ivan.SpringBootThymeleaf.Util.MahasiswaDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class MahasiswaController {
    @Autowired
    private MahasiswaDao mahasiswaDao;

//    @GetMapping
//    @RequestMapping({"/","/mahasiswas"})
//    public String main(@PageableDefault(size=5)Pageable pageable,Model model) {
//        Page<Mahasiswa> listMahasiswa=mahasiswaDao.findAll(pageable);
//        model.addAttribute("page",listMahasiswa);
//        return "index";
//    }

    @PostMapping
    @RequestMapping("getMahasiswa")
    public String getMahasiswa(String id, Model model) throws JsonProcessingException {
        Mahasiswa iu=mahasiswaDao.findById(id).get();
//        MahasiswaExt mahasiswaExt=new MahasiswaExt();
//        mahasiswaExt.setId(iu.getId());
//        mahasiswaExt.setIpk(iu.getIpk());
//        mahasiswaExt.setNim(iu.getNim());
//        mahasiswaExt.setNama(iu.getNama());
//        mahasiswaExt.setJurusan(iu.getJurusan());
//        mahasiswaExt.setCreatedDate(iu.getCreatedDate());
//        mahasiswaExt.setCreatedDateExt(iu.getCreatedDate());
//        mahasiswaExt.setUpdatedDate(iu.getUpdatedDate());
//        mahasiswaExt.setUpdatedDateExt(iu.getUpdatedDate());
        ObjectMapper Obj = new ObjectMapper();
        String rs=Obj.writeValueAsString(mahasiswaExt);
        return rs;
    }

    @PostMapping
    @RequestMapping("updateMahasiswa")
    public String updateMahasiswa(String id,String name,String jurusan,String nim,float ipk) {
        Mahasiswa iu=mahasiswaDao.findById(id).get();
        iu.setNama(name);
        iu.setJurusan(jurusan);
        iu.setNim(nim);
        iu.setIpk(ipk);
        iu.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        mahasiswaDao.save(iu);
        return "index";
    }

    @PostMapping
    @RequestMapping("saveMahasiswa")
    public String saveMahasiswa(String name,String jurusan,String nim,float ipk) {
        Mahasiswa iu=new Mahasiswa();
        iu.setNama(name);
        iu.setJurusan(jurusan);
        iu.setNim(nim);
        iu.setIpk(ipk);
        iu.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        mahasiswaDao.save(iu);
        return "index";
    }

    @PostMapping
    @RequestMapping("deleteMahasiswa")
    public String deleteMahasiswa(String id) {
        mahasiswaDao.deleteById(id);
        return "index";
    }
}
