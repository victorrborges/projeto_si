package com.ufcg.si1.service;

import org.springframework.stereotype.Service;

import com.ufcg.si1.model.queixa.Queixa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Queixa> queixasAbertas;
    private static List<Queixa> queixasFechadas;

    static {
        queixasAbertas = populateDummyQueixas();
    }

    private static List<Queixa> populateDummyQueixas() {
        List<Queixa> queixas = new ArrayList<Queixa>();

        queixas.add(new Queixa(counter.incrementAndGet(), "Passei mal com uma coxinha",
                3, "", "Jose Silva",
                "jose@gmail.com", "rua dos tolos", "PE", "Recife"));


        queixas.add(new Queixa(counter.incrementAndGet(),
                "Bacalhau estragado, passamos mal!", 3, "",
                "Ailton Sousa", "ailton@gmail.com", "rua dos bobos", "PB",
                "Joao Pessoa"));

        queixas.add(new Queixa(counter.incrementAndGet(), "Nossa rua estah muito suja", 3, "",
                "Jose Silva", "jose@gmail.com", "rua dos tolos", "PE", "Recife"));


        queixas.add(new Queixa(counter.incrementAndGet(), "iluminacao horrivel, muitos assaltos", 3, "",
                "Ailton Sousa", "ailton@gmail.com", "rua dos bobos", "PB",
                "Joao Pessoa"));

        return queixas;
    }

    public List<Queixa> findAllQueixas() {
        return queixasAbertas;
    }

    public void registraQueixa(Queixa queixa) {
        queixa.setId(counter.incrementAndGet());
        queixasAbertas.add(queixa);
    }

    public void updateQueixa(Queixa queixa) {
        int index = queixasAbertas.indexOf(queixa);
        queixasAbertas.set(index, queixa);
    }

    public void deleteQueixaById(long id) {

        for (Iterator<Queixa> iterator = queixasAbertas.iterator(); iterator.hasNext(); ) {
            Queixa q = iterator.next();
            if (q.getId() == id) {
                iterator.remove();
            }
        }
    }

    public void deleteAllUsers() {
        queixasAbertas.clear();
    }

    public Queixa findById(long id) {
        for (Queixa queixa : queixasAbertas) {
            if (queixa.getId() == id) {
                return queixa;
            }
        }
        return null;
    }
    
    public int numeroDeQueixasAbertas() {
    	return this.queixasAbertas.size();
    }

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	



}
