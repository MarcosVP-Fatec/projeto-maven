package br.gov.sp.fatec.projetomaven.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class LogFilter implements Filter {

    private ServletContext context;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        this.context.log(">>>>>>>>>>>>>>>>>>>>>> Filtro acessado !");
        this.context.log(req.toString());

        // Todo código aqui é executado antes da requisição chegar ao destino
        // Passa a requisição adiante

        // * Necessário fazer um cast porque com ServletResponce eu não consigo ter
        // acesso às características
        // * da minha resposta nem da minha requisição
        HttpServletResponse resp = (HttpServletResponse) res;
        resp.addHeader("In", ">>>>>>>>>>>>>>>>>>>>>> Eu passei pelo filtro na entrada!");
        // resp.addHeader("Usuario", "Mitces Valacae");

        chain.doFilter(req, res);

        // Todo código aqui é executado no retorno
        resp.addHeader("Out", ">>>>>>>>>>>>>>>>>>>>>> Eu passei pelo filtro na saída!");
        this.context.log("Resposta enviada!");
    }

    @Override
    public void destroy() {
        // Aqui pode-se desalocar qualquer recurso
    }

    /**
     * @apiNote init Contrutor do Filtro
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.context.log(">>>>>>>>>>>>>>>>>>>>>> Filtro inicializado!");
    }

}