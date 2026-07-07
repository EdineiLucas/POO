/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifnmg.aluno.elss2.fundamentosjava;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Edinei Lucas
 */
public class FundamentosJava {

    public static void main (String[] args){
        LocalDate hoje = LocalDate.now();
        
        System.err.println(">>" +  hoje);
        
        LocalDate aniversario = LocalDate.of(2001, 7, 16);
        
        System.out.println(">>" + aniversario);
        
        
                
    }
}
