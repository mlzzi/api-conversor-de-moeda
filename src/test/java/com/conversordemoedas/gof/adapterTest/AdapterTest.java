package com.conversordemoedas.gof.adapterTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AdapterTest {

//    @Mock
//    private OpenExchangeService openExchangeService;
//
//    @InjectMocks
//    private Adapter adapter; // Pode ser utilizado se precisar do Adapter para outros testes
//
//    @Value("${app_id}")
//    private String appId;
//
//    @BeforeEach
//    public void setUp() {
//        // Mockar a resposta da API
//        Map<String, Double> mockRates = new HashMap<>();
//        mockRates.put("GBP", 0.75);
//        mockRates.put("BRL", 5.25);
//        mockRates.put("EUR", 0.85);
//
//        adapter = new Adapter();
//        adapter.setTimestamp(1600000000);
//        adapter.setBase("USD");
//        adapter.setRates(mockRates);
//
//        // Configurar o comportamento do serviço mockado
//        when(openExchangeService.consultarCotacao(eq(appId), anyString())).thenReturn(adapter);
//    }
//
//    @Test
//    public void testConsultarCotacaoReal() {
//        Adapter resultado = openExchangeService.consultarCotacao(appId, "EUR");
//
//        // Verifique a resposta completa da API mockada
//        System.out.println("Resposta completa: " + resultado);
//
//        assertNotNull(resultado);
//        System.out.println("Timestamp: " + resultado.getTimestamp());
//
//        // Acessando a cotação da moeda
//        Map<String, Double> cotacaoBRL = resultado.getRates();
//        System.out.println("Cotação: " + cotacaoBRL);
//
//        // Verificando se a cotação é válida
//        assertNotNull(cotacaoBRL);
//        assertEquals(0.75, cotacaoBRL.get("GBP"));
//        assertEquals(5.25, cotacaoBRL.get("BRL"));
//        assertEquals(0.85, cotacaoBRL.get("EUR"));
//    }
}