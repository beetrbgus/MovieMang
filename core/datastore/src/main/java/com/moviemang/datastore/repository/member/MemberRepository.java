package com.moviemang.datastore.repository.member;

import org.springframework.data.repository.CrudRepository;

import com.moviemang.datastore.domain.member.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

}
