package hkmu.comps380f;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "storeServlet", value = "/shop")
public class StoreServlet extends HttpServlet {
    private final Map<Integer, String> products = new ConcurrentHashMap<>();

    public StoreServlet() {
        this.products.put(1, "Sandpaper");
        this.products.put(2, "Nails");
        this.products.put(3, "Glue");
        this.products.put(4, "Paint");
        this.products.put(5, "Tape");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "browse";

        switch (action) {
            case "addToCart":
                this.addToCart(request, response);
                break;
            case "viewCart":
                this.viewCart(request, response);
                break;
            case "emptyCart":
                this.emptyCart(request, response);
                break;
            case "browse":
            default:
                this.browse(request, response);
                break;
        }
    }

    // Defining other methods ...
    private void viewCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", this.products);
        request.getRequestDispatcher("/WEB-INF/jsp/viewCart.jsp")
                .forward(request, response);
    }

    private void browse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", this.products);
        request.getRequestDispatcher("/WEB-INF/jsp/browse.jsp")
                .forward(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int productId;
        try {
            productId = Integer.parseInt(request.getParameter("productId"));
        } catch (Exception e) {
            response.sendRedirect("shop");
            return;
        }

        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null)
            session.setAttribute("cart", new ConcurrentHashMap<>());

        @SuppressWarnings("unchecked")
        Map<Integer, Integer> cart
                = (Map<Integer, Integer>) session.getAttribute("cart");
        if (!cart.containsKey(productId))
            cart.put(productId, 0);
        cart.put(productId, cart.get(productId) + 1);

        response.sendRedirect("shop?action=viewCart");
    }

    private void emptyCart(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.getSession().removeAttribute("cart");
        response.sendRedirect("shop?action=viewCart");
    }
}
