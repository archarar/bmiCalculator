package com.example.bmicalculator;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class usersDao_Impl implements usersDao {
  private final RoomDatabase __db;

  private final EntityUpsertionAdapter<user> __upsertionAdapterOfuser;

  public usersDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__upsertionAdapterOfuser = new EntityUpsertionAdapter<user>(new EntityInsertionAdapter<user>(__db) {
      @Override
      public String createQuery() {
        return "INSERT INTO `USERS` (`heightft`,`heightin`,`heightTotal`,`neck`,`waist`,`bmi`,`id`) VALUES (?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, user value) {
        stmt.bindDouble(1, value.getHeightft());
        stmt.bindDouble(2, value.getHeightin());
        stmt.bindDouble(3, value.getHeightTotal());
        stmt.bindDouble(4, value.getNeck());
        stmt.bindDouble(5, value.getWaist());
        stmt.bindDouble(6, value.getBmi());
        stmt.bindLong(7, value.getId());
      }
    }, new EntityDeletionOrUpdateAdapter<user>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE `USERS` SET `heightft` = ?,`heightin` = ?,`heightTotal` = ?,`neck` = ?,`waist` = ?,`bmi` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, user value) {
        stmt.bindDouble(1, value.getHeightft());
        stmt.bindDouble(2, value.getHeightin());
        stmt.bindDouble(3, value.getHeightTotal());
        stmt.bindDouble(4, value.getNeck());
        stmt.bindDouble(5, value.getWaist());
        stmt.bindDouble(6, value.getBmi());
        stmt.bindLong(7, value.getId());
        stmt.bindLong(8, value.getId());
      }
    });
  }

  @Override
  public void insertUser(final user... user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __upsertionAdapterOfuser.upsert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<user>> getTallest() {
    final String _sql = "SELECT heightin, heightft, MAX(heightTotal) AS heightTotal, neck, waist, bmi, id FROM USERS";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"USERS"}, false, new Callable<List<user>>() {
      @Override
      public List<user> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHeightin = 0;
          final int _cursorIndexOfHeightft = 1;
          final int _cursorIndexOfHeightTotal = 2;
          final int _cursorIndexOfNeck = 3;
          final int _cursorIndexOfWaist = 4;
          final int _cursorIndexOfBmi = 5;
          final int _cursorIndexOfId = 6;
          final List<user> _result = new ArrayList<user>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final user _item;
            final double _tmpHeightin;
            _tmpHeightin = _cursor.getDouble(_cursorIndexOfHeightin);
            final double _tmpHeightft;
            _tmpHeightft = _cursor.getDouble(_cursorIndexOfHeightft);
            final double _tmpHeightTotal;
            _tmpHeightTotal = _cursor.getDouble(_cursorIndexOfHeightTotal);
            final double _tmpNeck;
            _tmpNeck = _cursor.getDouble(_cursorIndexOfNeck);
            final double _tmpWaist;
            _tmpWaist = _cursor.getDouble(_cursorIndexOfWaist);
            final double _tmpBmi;
            _tmpBmi = _cursor.getDouble(_cursorIndexOfBmi);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new user(_tmpHeightft,_tmpHeightin,_tmpHeightTotal,_tmpNeck,_tmpWaist,_tmpBmi,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<user>> getShortest() {
    final String _sql = "SELECT heightin, heightft, MIN(heightTotal) AS heightTotal, neck, waist, bmi, id FROM USERS";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"USERS"}, false, new Callable<List<user>>() {
      @Override
      public List<user> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHeightin = 0;
          final int _cursorIndexOfHeightft = 1;
          final int _cursorIndexOfHeightTotal = 2;
          final int _cursorIndexOfNeck = 3;
          final int _cursorIndexOfWaist = 4;
          final int _cursorIndexOfBmi = 5;
          final int _cursorIndexOfId = 6;
          final List<user> _result = new ArrayList<user>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final user _item;
            final double _tmpHeightin;
            _tmpHeightin = _cursor.getDouble(_cursorIndexOfHeightin);
            final double _tmpHeightft;
            _tmpHeightft = _cursor.getDouble(_cursorIndexOfHeightft);
            final double _tmpHeightTotal;
            _tmpHeightTotal = _cursor.getDouble(_cursorIndexOfHeightTotal);
            final double _tmpNeck;
            _tmpNeck = _cursor.getDouble(_cursorIndexOfNeck);
            final double _tmpWaist;
            _tmpWaist = _cursor.getDouble(_cursorIndexOfWaist);
            final double _tmpBmi;
            _tmpBmi = _cursor.getDouble(_cursorIndexOfBmi);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new user(_tmpHeightft,_tmpHeightin,_tmpHeightTotal,_tmpNeck,_tmpWaist,_tmpBmi,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<user>> getAvgBmi() {
    final String _sql = "SELECT heightin, heightft, heightTotal, neck, waist, AVG(bmi) AS bmi, id FROM USERS";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"USERS"}, false, new Callable<List<user>>() {
      @Override
      public List<user> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHeightin = 0;
          final int _cursorIndexOfHeightft = 1;
          final int _cursorIndexOfHeightTotal = 2;
          final int _cursorIndexOfNeck = 3;
          final int _cursorIndexOfWaist = 4;
          final int _cursorIndexOfBmi = 5;
          final int _cursorIndexOfId = 6;
          final List<user> _result = new ArrayList<user>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final user _item;
            final double _tmpHeightin;
            _tmpHeightin = _cursor.getDouble(_cursorIndexOfHeightin);
            final double _tmpHeightft;
            _tmpHeightft = _cursor.getDouble(_cursorIndexOfHeightft);
            final double _tmpHeightTotal;
            _tmpHeightTotal = _cursor.getDouble(_cursorIndexOfHeightTotal);
            final double _tmpNeck;
            _tmpNeck = _cursor.getDouble(_cursorIndexOfNeck);
            final double _tmpWaist;
            _tmpWaist = _cursor.getDouble(_cursorIndexOfWaist);
            final double _tmpBmi;
            _tmpBmi = _cursor.getDouble(_cursorIndexOfBmi);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new user(_tmpHeightft,_tmpHeightin,_tmpHeightTotal,_tmpNeck,_tmpWaist,_tmpBmi,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
