package elessons.lesson11.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TrigonometryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("functions", MathFunctions.values());
        request.getRequestDispatcher("input.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        calc(req, resp);

        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }

    private void calc(HttpServletRequest req, HttpServletResponse resp) {
        double angle = Double.parseDouble(req.getParameter("angleValue"));
        String func = req.getParameter("func");
        int prec = Integer.parseInt(req.getParameter("prec"));

        req.setAttribute("angle", angle);
        angle = req.getParameter("atype").equals("rad") ? angle : Math.toRadians(angle);
        MathFunctions mf = MathFunctions.valueOf(func.toUpperCase());

        req.setAttribute("result", mf.calc(angle));
        req.setAttribute("pattern", getPrecisionPattern(prec));
    }

    private String getPrecisionPattern(int prec) {
        StringBuilder sb = new StringBuilder();
        sb.append("###.");
        for(int i = 0; i < prec; i++) {
            sb.append("#");
        }
        return sb.toString();
    }

    public enum MathFunctions {
        SIN("sinus") {
            public double calc(double value) {
                return Math.sin(value);
            }
        },
        COS("cosine")  {
            public double calc(double value) {
                return Math.cos(value);
            }
        },
        TAN("tangent")  {
            public double calc(double value) {
                return Math.tan(value);
            }
        },
        ACOS("arc cosine")  {
            public double calc(double value) {
                return Math.acos(value);
            }
        },
        ASIN("arc sinus")  {
            public double calc(double value) {
                return Math.asin(value);
            }
        },
        ATAN("arc tangent")  {
            public double calc(double value) {
                return Math.atan(value);
            }
        };

        private String type;

        MathFunctions(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return name();
        }

        public abstract double calc(double value);
    }
}
