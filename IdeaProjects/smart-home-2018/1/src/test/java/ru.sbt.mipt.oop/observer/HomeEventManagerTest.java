package ru.sbt.mipt.oop.observer;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.homeComponents.SmartHome;
import ru.sbt.mipt.oop.observer.HomeEventManager;
import ru.sbt.mipt.oop.observer.HomeEventsObserver;
import ru.sbt.mipt.oop.observer.Observer;
import ru.sbt.mipt.oop.provider.SensorEventProvider;

import static org.mockito.Mockito.*;

public class HomeEventManagerTest {
    private Observer observer;
    private SensorEventProvider sensorEventProvider;
    private SmartHome smartHome;
    private SensorEvent event;


    @Before
    public void init() {
        event = mock(SensorEvent.class);
        when(event.toString()).thenReturn("mockEvent");

        observer = mock(HomeEventsObserver.class);
        doNothing().when(observer).notifySubscribers(smartHome, mock(SensorEvent.class));

        sensorEventProvider = mock(SensorEventProvider.class);
        when(sensorEventProvider.getNextSensorEvent()).thenReturn(event).thenReturn(null);

        smartHome = mock(SmartHome.class);
    }

    @Test
    public void runEventsCycleTest() {
        new HomeEventManager(observer, sensorEventProvider).runEventsCycle(smartHome);
        verify(observer, times(1)).notifySubscribers(any(), any());
    }
}
