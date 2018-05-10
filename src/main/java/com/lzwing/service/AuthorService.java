package com.lzwing.service;

import com.lzwing.dao.AuthorMapper;
import com.lzwing.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorMapper authorMapper;
 
    public int add(String realName, String nickName) {
        return this.authorMapper.add(realName, nickName);
    }
    public int update(String realName, String nickName, Long id) {
        return this.authorMapper.update(realName, nickName, id);      
    }
    public int delete(Long id) {
        return this.authorMapper.delete(id);
    }
    public Author findAuthor(Long id) {
        return this.authorMapper.findAuthor(id);
    }
    public List<Author> findAuthorList() {
        return this.authorMapper.findAuthorList();
    }
}