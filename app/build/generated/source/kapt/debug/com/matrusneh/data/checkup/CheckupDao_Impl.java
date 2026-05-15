package com.matrusneh.data.checkup;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
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
public final class CheckupDao_Impl implements CheckupDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CheckupRecord> __insertionAdapterOfCheckupRecord;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  public CheckupDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCheckupRecord = new EntityInsertionAdapter<CheckupRecord>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `checkup_records` (`id`,`lastDateIso`,`nextDateIso`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CheckupRecord entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getLastDateIso() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getLastDateIso());
        }
        if (entity.getNextDateIso() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNextDateIso());
        }
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM checkup_records";
        return _query;
      }
    };
  }

  @Override
  public Object upsert(final CheckupRecord record, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCheckupRecord.insert(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clear(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClear.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClear.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object latest(final Continuation<? super CheckupRecord> $completion) {
    final String _sql = "SELECT * FROM checkup_records ORDER BY id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<CheckupRecord>() {
      @Override
      @Nullable
      public CheckupRecord call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLastDateIso = CursorUtil.getColumnIndexOrThrow(_cursor, "lastDateIso");
          final int _cursorIndexOfNextDateIso = CursorUtil.getColumnIndexOrThrow(_cursor, "nextDateIso");
          final CheckupRecord _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpLastDateIso;
            if (_cursor.isNull(_cursorIndexOfLastDateIso)) {
              _tmpLastDateIso = null;
            } else {
              _tmpLastDateIso = _cursor.getString(_cursorIndexOfLastDateIso);
            }
            final String _tmpNextDateIso;
            if (_cursor.isNull(_cursorIndexOfNextDateIso)) {
              _tmpNextDateIso = null;
            } else {
              _tmpNextDateIso = _cursor.getString(_cursorIndexOfNextDateIso);
            }
            _result = new CheckupRecord(_tmpId,_tmpLastDateIso,_tmpNextDateIso);
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
