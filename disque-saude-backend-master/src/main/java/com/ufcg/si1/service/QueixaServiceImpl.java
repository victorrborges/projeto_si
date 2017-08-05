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

    private static List<Queixa> queixas;

    static {
        queixas = populateDummyQueixas();
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
        return queixas;
    }

    public void saveQueixa(Queixa queixa) {
        queixa.setId(counter.incrementAndGet());
        queixas.add(queixa);
    }

    public void updateQueixa(Queixa queixa) {
        int index = queixas.indexOf(queixa);
        queixas.set(index, queixa);
    }

    public void deleteQueixaById(long id) {

        for (Iterator<Queixa> iterator = queixas.iterator(); iterator.hasNext(); ) {
            Queixa q = iterator.next();
            if (q.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    //este metodo nunca eh chamado, mas se precisar estah aqui
    public int size() {
        return queixas.size();
    }

    @Override
    public Iterator<Queixa> getIterator() {
        return queixas.iterator();
    }

    public void deleteAllUsers() {
        queixas.clear();
    }

    public Queixa findById(long id) {
        for (Queixa queixa : queixas) {
            if (queixa.getId() == id) {
                return queixa;
            }
        }
        return null;
    }



}
