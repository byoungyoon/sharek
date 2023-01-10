interface PersistentStorage {
  getItem(key: string): string | null;
  setItem(key: string, value: any): void;
}

class LocalStorage implements PersistentStorage {
  getItem(key: string) {
    const item = localStorage.getItem(key);

    if (item === null || item === undefined) return null;

    try {
      return JSON.parse(item);
    } catch {}

    return item;
  }

  setItem(key: string, value?: any) {
    if (value) localStorage.removeItem(key);
    else localStorage.setItem(key, JSON.stringify(value));
  }
}

export const persistentStorage = new LocalStorage();
