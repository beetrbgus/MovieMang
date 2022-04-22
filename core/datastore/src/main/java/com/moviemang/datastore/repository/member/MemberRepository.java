package com.moviemang.datastore.repository.member;

import org.springframework.data.repository.CrudRepository;

import com.moviemang.datastore.domain.member.Member;


public interface MemberRepository extends CrudRepository<Member, Long> {

} 
