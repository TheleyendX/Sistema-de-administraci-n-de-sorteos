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
import java.time.LocalDateTime;
import java.time.Month;
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
        System.out.println("Iniciando pruebas para SorteoTest...");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Finalizando pruebas para SorteoTest...");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Iniciando una nueva prueba...");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Prueba finalizada.");
    }

    // Helper para crear fechas rápidamente
    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Meses en Calendar comienzan desde 0
        return calendar.getTime();
    }

    @Test
    public void testNumeroInicialFinalValido() {
        Sorteo sorteo = new Sorteo();
        sorteo.setNumeroInicial(1);
        sorteo.setNumeroFinal(10); // Configuración de número inicial y final válidos
        assertEquals(1, sorteo.getNumeroInicial());
        assertEquals(10, sorteo.getNumeroFinal());
    }

    @Test
    public void testPrecioBoletoValido() {
        Sorteo sorteo = new Sorteo();
        sorteo.setPrecioNumero(20.0f);
        assertTrue(sorteo.getPrecioNumero() > 0, "El precio del boleto debe ser mayor a 0");
    }

    @Test
    public void testPrecioBoletoInvalido() {
        Sorteo sorteo = new Sorteo();
        sorteo.setPrecioNumero(-5.0f);
        assertTrue(sorteo.getPrecioNumero() <= 0, "El precio del boleto no puede ser negativo");
    }

    @Test
    public void testFechaSorteo() {
        Sorteo sorteo = new Sorteo();
        Date fecha = createDate(2024, 12, 25);
        sorteo.setFechaInicio(fecha);
        assertNotNull(sorteo.getFechaInicio(), "La fecha de inicio del sorteo no debe ser nula");
        assertEquals(fecha, sorteo.getFechaInicio(), "La fecha del sorteo no coincide con la esperada");
    }

    @Test
    public void testFechasInicioFinValidas() {
        Sorteo sorteo = new Sorteo();
        Date fechaInicio = createDate(2024, 11, 1);
        Date fechaFin = createDate(2024, 12, 1);

        sorteo.setFechaInicio(fechaInicio);
        sorteo.setFechaFin(fechaFin);

        assertTrue(sorteo.getFechaInicio().before(sorteo.getFechaFin()), "La fecha de inicio debe ser anterior a la fecha de fin");
    }

    @Test
    public void testFechasInicioFinInvalidas() {
        Sorteo sorteo = new Sorteo();
        Date fechaInicio = createDate(2024, 12, 1);
        Date fechaFin = createDate(2024, 11, 1);

        sorteo.setFechaInicio(fechaInicio);
        sorteo.setFechaFin(fechaFin);

        assertFalse(sorteo.getFechaInicio().before(sorteo.getFechaFin()), "La fecha de inicio no puede ser posterior a la fecha de fin");
    }

    @Test
    public void testEstadoSorteoPorDefecto() {
        Sorteo sorteo = new Sorteo();
        assertEquals(EstadoSorteo.ACTIVO, sorteo.getEstadoSorteo(), "El estado por defecto del sorteo debe ser ACTIVO");
    }

    @Test
    public void testCambiarEstadoSorteo() {
        Sorteo sorteo = new Sorteo();
        sorteo.setEstadoSorteo(EstadoSorteo.INACTIVO);
        assertEquals(EstadoSorteo.INACTIVO, sorteo.getEstadoSorteo(), "El estado del sorteo no se actualizó correctamente");
    }
}
