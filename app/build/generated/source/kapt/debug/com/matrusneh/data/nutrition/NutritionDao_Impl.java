package com.matrusneh.data.nutrition;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NutritionDao_Impl implements NutritionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NutritionLog> __insertionAdapterOfNutritionLog;

  public NutritionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNutritionLog = new EntityInsertionAdapter<NutritionLog>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `nutrition_logs` (`id`,`dateIso`,`ragi`,`greens`,`pulses`,`milk`,`fruits`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NutritionLog entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getDateIso() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDateIso());
        }
        final int _tmp = entity.getRagi() ? 1 : 0;
        statement.bindLong(3, _tmp);
        final int _tmp_1 = entity.getGreens() ? 1 : 0;
        statement.bindLong(4, _tmp_1);
        final int _tmp_2 = entity.getPulses() ? 1 : 0;
        statement.bindLong(5, _tmp_2);
        final int _tmp_3 = entity.getMilk() ? 1 : 0;
        statement.bindLong(6, _tmp_3);
        final int _tmp_4 = entity.getFruits() ? 1 : 0;
        statement.bindLong(7, _tmp_4);
      }
    };
  }

  @Override
  public Object upsert(final NutritionLog log, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNutritionLog.insert(log);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getByDate(final String dateIso,
      final Continuation<? super NutritionLog> $completion) {
    final String _sql = "SELECT * FROM nutrition_logs WHERE dateIso = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dateIso == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dateIso);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<NutritionLog>() {
      @Override
      @Nullable
      public NutritionLog call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDateIso = CursorUtil.getColumnIndexOrThrow(_cursor, "dateIso");
          final int _cursorIndexOfRagi = CursorUtil.getColumnIndexOrThrow(_cursor, "ragi");
          final int _cursorIndexOfGreens = CursorUtil.getColumnIndexOrThrow(_cursor, "greens");
          final int _cursorIndexOfPulses = CursorUtil.getColumnIndexOrThrow(_cursor, "pulses");
          final int _cursorIndexOfMilk = CursorUtil.getColumnIndexOrThrow(_cursor, "milk");
          final int _cursorIndexOfFruits = CursorUtil.getColumnIndexOrThrow(_cursor, "fruits");
          final NutritionLog _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpDateIso;
            if (_cursor.isNull(_cursorIndexOfDateIso)) {
              _tmpDateIso = null;
            } else {
              _tmpDateIso = _cursor.getString(_cursorIndexOfDateIso);
            }
            final boolean _tmpRagi;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfRagi);
            _tmpRagi = _tmp != 0;
            final boolean _tmpGreens;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfGreens);
            _tmpGreens = _tmp_1 != 0;
            final boolean _tmpPulses;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfPulses);
            _tmpPulses = _tmp_2 != 0;
            final boolean _tmpMilk;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfMilk);
            _tmpMilk = _tmp_3 != 0;
            final boolean _tmpFruits;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfFruits);
            _tmpFruits = _tmp_4 != 0;
            _result = new NutritionLog(_tmpId,_tmpDateIso,_tmpRagi,_tmpGreens,_tmpPulses,_tmpMilk,_tmpFruits);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
