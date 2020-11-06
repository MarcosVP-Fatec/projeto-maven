package br.gov.sp.fatec.projetomaven.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Esta classe vai atender a uma URL específica
// Para cada método de requisição http teremos um método aqui
// Toda classe serializável (que pode ser transformada em texto para transporte) precisa de um 
// serial version id que é gerado com base nos caracteres do código
public class MainController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().print("<h1>Bem vindo!</h1>"); /*Isso coloca o texto no corpo da resposta*/
    }    
    
}