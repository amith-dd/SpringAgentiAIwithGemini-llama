package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SalaryPayment;

public interface SalaryPaymentRepo extends JpaRepository<SalaryPayment, Integer> {

}
