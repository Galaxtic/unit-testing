package Business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);
    @Test
    public void size_basic() {

        when(mock.size()).thenReturn(5);
        Assertions.assertEquals(5, mock.size());
    }

    @Test
    public void ReturnDiffValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        Assertions.assertEquals(5, mock.size());
        Assertions.assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("inLemnisk");
        Assertions.assertEquals("inLemnisk", mock.get(0));
    }

    @Test
    public void returnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("inLemnisk");
        Assertions.assertEquals("inLemnisk", mock.get(65));
    }

    @Test
    public void VerificationBasics(){
        //SUT(system under test)
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void ArgumentCapturing(){
        //SUT(System Under Test)
        mock.add("Some String");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        Assertions.assertEquals("Some String", captor.getValue());

    }

    @Test
    public void multipleArgumentCapturing(){
        //SUT(System Under Test)
        mock.add("Some String1");
        mock.add("Some String2");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        Assertions.assertEquals("Some String1", allValues.get(0));
        Assertions.assertEquals("Some String2", allValues.get(1));

    }

    @Test
    public void mocking(){
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));//null
        System.out.println(arrayListMock.size());//0
        arrayListMock.add("Test");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());//0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());//5
    }

    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));
        System.out.println(arrayListSpy.size());//1
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());//2
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());//5
        arrayListSpy.add("Test2");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());

        verify(arrayListSpy).add("Test4");
    }
}
