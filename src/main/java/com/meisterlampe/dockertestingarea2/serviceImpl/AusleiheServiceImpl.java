package com.meisterlampe.dockertestingarea2.serviceImpl;
import com.meisterlampe.dockertestingarea2.entities.Ausleihe;
import com.meisterlampe.dockertestingarea2.entities.Books;
import com.meisterlampe.dockertestingarea2.entities.User;
import com.meisterlampe.dockertestingarea2.repository.AusleiheRepository;
import com.meisterlampe.dockertestingarea2.repository.BookRepository;
import com.meisterlampe.dockertestingarea2.repository.UserRepository;
import com.meisterlampe.dockertestingarea2.services.AusleiheService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Service
@AllArgsConstructor
public class AusleiheServiceImpl implements AusleiheService {
    @Resource
    private BookRepository bookrepository;
    @Resource
    private AusleiheRepository ausleiheRepository;
    @Resource
    private UserRepository userRepository;


public Ausleihe ausleihen(Integer iduser , Integer idbooks){
    User user = userRepository.findById(iduser).orElse(null);
    Books book = bookrepository.findById(idbooks).orElse(null);

    if(user!=null && book!=null && book.getStock()>0){
        Ausleihe ausleihe = new Ausleihe();
        ausleihe.setUser(user);
        ausleihe.setAusgelieheneBucher(book);
        ausleihe.setAusleihe(Timestamp.valueOf(LocalDateTime.now()));
        ausleihe.setRueckgabe(null);

        book.setStock(book.getStock()-1);

        bookrepository.save(book);

        return ausleiheRepository.save(ausleihe);
    }

 return null;
}


public void buchZuruckgeben(int idbookorder){

    Ausleihe ausleihe = ausleiheRepository.findById(idbookorder).orElse(null);


    if(ausleihe != null){
        ausleihe.setRueckgabe(Timestamp.valueOf(LocalDateTime.now()));
        ausleiheRepository.save(ausleihe);

        Books book = ausleihe.getAusgelieheneBucher();
        book.setStock(book.getStock()+1);
        bookrepository.save(book);

    }
}
    @Override
    public Iterable<Ausleihe> ausleiheAlle() {
        return ausleiheRepository.findAll();
    }

}
