package com.example.project_5;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class RealmHelper {
    private Context context;
    private Realm realm;
    public RealmHelper(Context context) {
        this.context = context;

        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void insertData(CatatanModel catatan){
        realm.beginTransaction();
        realm.copyToRealm(catatan);
        realm.commitTransaction();
        realm.addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                Toast.makeText(context, "Data berhasil di tambah..", Toast.LENGTH_SHORT).show();
            }
        });
        realm.close();
    }

    public long getNextId(){

        if (realm.where(CatatanModel.class).count() != 0){
            long id =realm.where(CatatanModel.class).max("id").longValue();
            return id+1;
        }else {
            return 1;
        }
    }

    public List<CatatanModel> showData(){
        RealmResults<CatatanModel> datahasil = realm.where(CatatanModel.class).findAll();
        List<CatatanModel> datalist = new ArrayList<>();
        datalist.addAll(realm.copyFromRealm(datahasil));
        return datalist;
    }

    public CatatanModel showOneData(int id){
        CatatanModel catatan = realm.where(CatatanModel.class).equalTo("id", id).findFirst();
        return catatan;
    }

    public void updateData(CatatanModel catatanModel){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(catatanModel);
        realm.commitTransaction();
        realm.addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                Toast.makeText(context, "Data berhasil diupdate..", Toast.LENGTH_SHORT).show();
            }
        });
        realm.close();
    }

    public void deleteData(Integer id){
        realm.beginTransaction();
        CatatanModel catatan = realm.where(CatatanModel.class).equalTo("id", id).findFirst();
        catatan.deleteFromRealm();
        realm.commitTransaction();
        realm.addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                Toast.makeText(context, "Data berhasil dihapus..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
