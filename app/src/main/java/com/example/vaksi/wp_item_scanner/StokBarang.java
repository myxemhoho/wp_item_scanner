package com.example.vaksi.wp_item_scanner;

/**
 * Created by Vaksi on 9/30/16.
 */

public class StokBarang {
    private String id;
    private String barang_id;
    private String stok;
    private String keluar_masuk_barang_id;
    private String created_at;
    private String updated_at;

    public String getId() {
        return this.id;
    }

    public String getBarangId() {
        return this.barang_id;
    }
    public String getStok() {
        return this.stok;
    }

    public String getKeluarMasukBarangId(){
        return this.keluar_masuk_barang_id;
    }

    public String getCreatedAt(){
        return this.created_at;
    }

    public String getUpdatedAt(){
        return this.updated_at;
    }
}
