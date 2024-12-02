/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Entidades.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class SorteoTest {
    
    public SorteoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // Helper para crear fechas rápidamente
    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Meses en Calendar comienzan desde 0
        return calendar.getTime();
    }

    @Test
    public void testRangoNumerosValido() {
        Sorteo sorteo = new Sorteo();
        sorteo.setRangoNumeros("1-10"); // Configuración de rango válido
        assertEquals("1-10", sorteo.getRangoNumeros());
    }

    @Test
    public void testRangoNumerosInvalido() {
        Sorteo sorteo = new Sorteo();
        sorteo.setRangoNumeros("10-1"); // Configuración de rango inválido
        // Asume que tienes una validación separada para esto
        assertNotEquals("10-1", sorteo.getRangoNumeros());
    }

    @Test
    public void testPrecioBoletoValido() {
        Sorteo sorteo = new Sorteo();
        sorteo.setPrecioNumero(20.0f);
        assertTrue(sorteo.getPrecioNumero() > 0);
    }

    @Test
    public void testPrecioBoletoInvalido() {
        Sorteo sorteo = new Sorteo();
        sorteo.setPrecioNumero(-5.0f);
        assertTrue(sorteo.getPrecioNumero() <= 0); // Esperamos un precio inválido
    }

    @Test
    public void testPeriodoVentaValido() {
        Sorteo sorteo = new Sorteo();
        sorteo.setPeriodoVenta(Duration.ofDays(30)); // 30 días de duración
        assertEquals(Duration.ofDays(30), sorteo.getPeriodoVenta());
    }

    @Test
    public void testPeriodoVentaInvalido() {
        Sorteo sorteo = new Sorteo();
        sorteo.setPeriodoVenta(Duration.ofDays(-5)); // Duración negativa
        assertTrue(sorteo.getPeriodoVenta().isNegative());
    }

    @Test
    public void testFechaSorteo() {
        Sorteo sorteo = new Sorteo();
        Date fecha = createDate(2024, 12, 25);
        sorteo.setFechaSorteo(fecha);
        assertEquals(fecha, sorteo.getFechaSorteo());
    }

    @Test
    public void testFechasInicioFinValidas() {
        Sorteo sorteo = new Sorteo();
        Date fechaInicio = createDate(2024, 11, 1);
        Date fechaFin = createDate(2024, 12, 1);

        sorteo.setFechaInicio(fechaInicio);
        sorteo.setFechaFin(fechaFin);

        assertTrue(sorteo.getFechaInicio().before(sorteo.getFechaFin()));
    }

    @Test
    public void testFechasInicioFinInvalidas() {
        Sorteo sorteo = new Sorteo();
        Date fechaInicio = createDate(2024, 12, 1);
        Date fechaFin = createDate(2024, 11, 1);

        sorteo.setFechaInicio(fechaInicio);
        sorteo.setFechaFin(fechaFin);

        assertFalse(sorteo.getFechaInicio().before(sorteo.getFechaFin()));
    }

    @Test
    public void testEstadoSorteoPorDefecto() {
        Sorteo sorteo = new Sorteo();
        assertEquals(EstadoSorteo.ACTIVO, sorteo.getEstadoSorteo());
    }

    @Test
    public void testCambiarEstadoSorteo() {
        Sorteo sorteo = new Sorteo();
        sorteo.setEstadoSorteo(EstadoSorteo.INACTIVO);
        assertEquals(EstadoSorteo.INACTIVO, sorteo.getEstadoSorteo());
    }
}
