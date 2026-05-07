package org.abdullah.unislot.exception;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ExceptionMessageResolver {

    public String resolve(Throwable exception) {
        String mesaj = collectMessages(exception).toLowerCase(Locale.ROOT);

        if (mesaj.contains("ayni yariyildaki zorunlu derslerin sinavlari ayni tarih ve oturumda olamaz")) {
            return "Aynı yarıyıldaki zorunlu derslerin sınavları aynı tarih ve aynı oturumda olamaz.";
        }

        if (mesaj.contains("ayni yariyil icin ayni gune 2den fazla sinav atanamaz")) {
            return "Aynı yarıyıl için aynı güne 2’den fazla sınav atanamaz.";
        }

        if (mesaj.contains("uq_derssinav") || mesaj.contains("duplicate key")) {
            return "Bu ders için aynı tarihte zaten sınav oluşturulmuş.";
        }

        if (mesaj.contains("bu sinava zaten salon atanmis") || mesaj.contains("zaten salon atanmis")) {
            return "Bu sınava zaten salon atanmış.";
        }

        if (mesaj.contains("musait salonlarin toplam kapasitesi yetersiz")) {
            return "Müsait dersliklerin toplam kapasitesi bu sınav için yetersiz.";
        }

        if (mesaj.contains("bu sinava once salon atamasi yapilmalidir")
                || mesaj.contains("once salon atamasi yapilmalidir")) {
            return "Gözetmen ataması yapmadan önce salon ataması yapılmalıdır.";
        }

        if (mesaj.contains("bu sinava zaten gozetmen atanmis")
                || mesaj.contains("zaten gozetmen atanmis")) {
            return "Bu sınava zaten gözetmen atanmış.";
        }

        if (mesaj.contains("uygun gozetmen bulunamadi")) {
            return "Bu sınav için uygun gözetmen bulunamadı.";
        }

        if (mesaj.contains("sinav bulunamadi")) {
            return "Sınav bulunamadı.";
        }

        if (mesaj.contains("ders ogrenci sayisi gecersiz")) {
            return "Dersin öğrenci sayısı geçersiz.";
        }

        if (mesaj.contains("ders, tarih ve oturum bilgileri zorunludur")) {
            return "Ders, tarih ve oturum bilgileri zorunludur.";
        }

        if (mesaj.contains("guncellenecek sinav bulunamadi")
                || mesaj.contains("güncellenecek sinav bulunamadi")) {
            return "Güncellenecek sınav bulunamadı.";
        }

        if (mesaj.contains("gecersiz oturum secildi")
                || mesaj.contains("geçersiz oturum seçildi")) {
            return "Geçersiz oturum seçildi.";
        }

        if (mesaj.contains("ayni yariyildaki zorunlu derslerin sinavlari ayni tarih ve oturumda olamaz")) {
            return "Aynı yarıyıldaki zorunlu derslerin sınavları aynı tarih ve aynı oturumda olamaz.";
        }

        if (mesaj.contains("ayni yariyil icin ayni gune 2den fazla sinav atanamaz")) {
            return "Aynı yarıyıl için aynı güne 2’den fazla sınav atanamaz.";
        }

        if (mesaj.contains("sp_sinavguncelle")) {
            return "Sınav güncellenirken hata oluştu. Seçilen tarih ve oturum bilgilerini kontrol edin.";
        }

        if (mesaj.contains("trg_sinavguncellemelog")) {
            return "Sınav güncelleme log kaydı oluşturulurken hata oluştu.";
        }

        return "İşlem sırasında beklenmeyen bir hata oluştu.";

    }

    private String collectMessages(Throwable exception) {
        StringBuilder builder = new StringBuilder();

        Throwable current = exception;

        while (current != null) {
            if (current.getMessage() != null) {
                builder.append(current.getMessage()).append(" ");
            }

            current = current.getCause();
        }

        return builder.toString();
    }
}