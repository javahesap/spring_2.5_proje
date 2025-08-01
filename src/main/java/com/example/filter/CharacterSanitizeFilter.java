package com.example.filter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CharacterSanitizeFilter implements Filter {

    // Özel karakterleri temizleyen statik metod
    private static String sanitize(String input) {
        if (input == null) return null;
        // Temizlenecek karakterler: ' , - ?
        return input.replaceAll("[',\\-?]", "");
    }

    // HttpServletRequest sarmalayıcı (wrapper) sınıfı
    private static class SanitizedRequest extends HttpServletRequestWrapper {

        private final Map<String, String[]> sanitizedParams = new HashMap<>();

        public SanitizedRequest(HttpServletRequest request) {
            super(request);

            // Orijinal parametreleri al ve temizle
            Map<String, String[]> originalParams = request.getParameterMap();

            for (String key : originalParams.keySet()) {
                String[] values = originalParams.get(key);
                String[] sanitizedValues = new String[values.length];

                for (int i = 0; i < values.length; i++) {
                    sanitizedValues[i] = sanitize(values[i]);
                }

                sanitizedParams.put(key, sanitizedValues);
            }
        }

        @Override
        public String getParameter(String name) {
            String[] values = sanitizedParams.get(name);
            if (values != null && values.length > 0) {
                return values[0];
            }
            return null;
        }

        @Override
        public String[] getParameterValues(String name) {
            return sanitizedParams.get(name);
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return sanitizedParams;
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Gerekirse filtre başlatma işlemleri
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (request instanceof HttpServletRequest) {
            SanitizedRequest sanitizedRequest = new SanitizedRequest((HttpServletRequest) request);
            chain.doFilter(sanitizedRequest, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Gerekirse filtre kapatma işlemleri
    }
}
