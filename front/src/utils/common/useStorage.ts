interface PersistentStorage {
  getItem(key: string): string | null;
  setItem<T>(key: string, value: T): void;
}

class LocalStorage implements PersistentStorage {
  item: string;

  constructor() {
    this.item = '';
  }

  getItem(key: string) {
    const item = localStorage.getItem(key);
    if (item === null || item === undefined) return null;

    this.item = item;

    try {
      return JSON.parse(item);
    } catch (error) {
      return Promise.reject();
    }
  }

  setItem<T>(key: string, value?: T) {
    this.item = key;

    if (value) localStorage.removeItem(this.item);
    else localStorage.setItem(this.item, JSON.stringify(value));
  }
}

export const useStorage = new LocalStorage();
