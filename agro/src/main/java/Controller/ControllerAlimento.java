package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerAlimento extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ControllerAlimento() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if ("create".equals(acao)) {
            try {
                String alimento = request.getParameter("alimento");
                String variedade = request.getParameter("variedade");
                String[] classificacoes = request.getParameterValues("classificacoes"); // Recebe as múltiplas classificações

                // Exibe os dados para verificação
                System.out.println("Ação: " + acao);
                System.out.println("Alimento: " + alimento);
                System.out.println("Variedade: " + variedade);
                System.out.println("Classificações: " + (classificacoes != null ? String.join(", ", classificacoes) : "Nenhuma"));

                // Aqui você pode processar esses dados, como salvar no banco de dados

                // Resposta de sucesso
                response.setContentType("application/json");
                response.getWriter().write("{\"message\": \"Alimento cadastrado com sucesso!\"}");

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("{\"message\": \"Erro ao processar a solicitação\"}");
            }
        }
    }
}
