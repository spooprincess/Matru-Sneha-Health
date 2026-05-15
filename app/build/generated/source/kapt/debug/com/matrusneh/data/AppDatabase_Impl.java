package com.matrusneh.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.matrusneh.data.checkup.CheckupDao;
import com.matrusneh.data.checkup.CheckupDao_Impl;
import com.matrusneh.data.kick.KickDao;
import com.matrusneh.data.kick.KickDao_Impl;
import com.matrusneh.data.nutrition.NutritionDao;
import com.matrusneh.data.nutrition.NutritionDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile KickDao _kickDao;

  private volatile CheckupDao _checkupDao;

  private volatile NutritionDao _nutritionDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `kick_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `checkup_records` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `lastDateIso` TEXT NOT NULL, `nextDateIso` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `nutrition_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `dateIso` TEXT NOT NULL, `ragi` INTEGER NOT NULL, `greens` INTEGER NOT NULL, `pulses` INTEGER NOT NULL, `milk` INTEGER NOT NULL, `fruits` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cf6a64e31089e68e7be6e3d01925f814')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `kick_logs`");
        db.execSQL("DROP TABLE IF EXISTS `checkup_records`");
        db.execSQL("DROP TABLE IF EXISTS `nutrition_logs`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsKickLogs = new HashMap<String, TableInfo.Column>(2);
        _columnsKickLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKickLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKickLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKickLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKickLogs = new TableInfo("kick_logs", _columnsKickLogs, _foreignKeysKickLogs, _indicesKickLogs);
        final TableInfo _existingKickLogs = TableInfo.read(db, "kick_logs");
        if (!_infoKickLogs.equals(_existingKickLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "kick_logs(com.matrusneh.data.kick.KickLog).\n"
                  + " Expected:\n" + _infoKickLogs + "\n"
                  + " Found:\n" + _existingKickLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsCheckupRecords = new HashMap<String, TableInfo.Column>(3);
        _columnsCheckupRecords.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckupRecords.put("lastDateIso", new TableInfo.Column("lastDateIso", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckupRecords.put("nextDateIso", new TableInfo.Column("nextDateIso", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCheckupRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCheckupRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCheckupRecords = new TableInfo("checkup_records", _columnsCheckupRecords, _foreignKeysCheckupRecords, _indicesCheckupRecords);
        final TableInfo _existingCheckupRecords = TableInfo.read(db, "checkup_records");
        if (!_infoCheckupRecords.equals(_existingCheckupRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "checkup_records(com.matrusneh.data.checkup.CheckupRecord).\n"
                  + " Expected:\n" + _infoCheckupRecords + "\n"
                  + " Found:\n" + _existingCheckupRecords);
        }
        final HashMap<String, TableInfo.Column> _columnsNutritionLogs = new HashMap<String, TableInfo.Column>(7);
        _columnsNutritionLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("dateIso", new TableInfo.Column("dateIso", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("ragi", new TableInfo.Column("ragi", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("greens", new TableInfo.Column("greens", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("pulses", new TableInfo.Column("pulses", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("milk", new TableInfo.Column("milk", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNutritionLogs.put("fruits", new TableInfo.Column("fruits", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNutritionLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNutritionLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNutritionLogs = new TableInfo("nutrition_logs", _columnsNutritionLogs, _foreignKeysNutritionLogs, _indicesNutritionLogs);
        final TableInfo _existingNutritionLogs = TableInfo.read(db, "nutrition_logs");
        if (!_infoNutritionLogs.equals(_existingNutritionLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "nutrition_logs(com.matrusneh.data.nutrition.NutritionLog).\n"
                  + " Expected:\n" + _infoNutritionLogs + "\n"
                  + " Found:\n" + _existingNutritionLogs);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "cf6a64e31089e68e7be6e3d01925f814", "1907f99df71614ad47e63260c89e327d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "kick_logs","checkup_records","nutrition_logs");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `kick_logs`");
      _db.execSQL("DELETE FROM `checkup_records`");
      _db.execSQL("DELETE FROM `nutrition_logs`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(KickDao.class, KickDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CheckupDao.class, CheckupDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NutritionDao.class, NutritionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public KickDao kickDao() {
    if (_kickDao != null) {
      return _kickDao;
    } else {
      synchronized(this) {
        if(_kickDao == null) {
          _kickDao = new KickDao_Impl(this);
        }
        return _kickDao;
      }
    }
  }

  @Override
  public CheckupDao checkupDao() {
    if (_checkupDao != null) {
      return _checkupDao;
    } else {
      synchronized(this) {
        if(_checkupDao == null) {
          _checkupDao = new CheckupDao_Impl(this);
        }
        return _checkupDao;
      }
    }
  }

  @Override
  public NutritionDao nutritionDao() {
    if (_nutritionDao != null) {
      return _nutritionDao;
    } else {
      synchronized(this) {
        if(_nutritionDao == null) {
          _nutritionDao = new NutritionDao_Impl(this);
        }
        return _nutritionDao;
      }
    }
  }
}
